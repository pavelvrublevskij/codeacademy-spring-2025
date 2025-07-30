import { Field, Form, Formik, FormikProps } from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';

interface LoginError {
    email?: string;
    password?: string;
}

interface LoginValues {
    email: string;
    password: string;
}

const LoginPage = () => {

    const validate = (login: LoginValues) => {

        const errors: LoginError = {}

        if (!login.email.includes("@")) {
            errors.email = "CIA NE EMAIL'AS!!!";
        }

        if (login.password.length < 6 ) {
            errors.password = "Slaptazodzio ilgis turi buti >= 6"
        }

        return errors
    }

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={(login: LoginValues, helper) => {

                console.log('login', login);
            }}
            validate={validate}
        >
            {
                (props: FormikProps<LoginValues>) => {
                    console.log('React formik props', props)

                    return (
                        <Container>
                            <Form>
                                <Field name="email" component={FormikFieldInputGroup} labelText="Email:" type="text" />
                                <Field name="password" component={FormikFieldInputGroup} labelText="Password:" type="password" />
                                <div className="text-center">
                                    {props.isSubmitting
                                        ? <Button variant='primary' disabled>
                                            <Spinner
                                                as='span'
                                                animation='grow'
                                                size='sm'
                                                role='status'
                                                aria-hidden='true'
                                            />
                                            Processing...
                                        </Button>
                                        :  <Button type='submit'
                                                   variant='primary'>
                                            Submit
                                        </Button>
                                    }
                                </div>
                            </Form>
                        </Container>
                    )
                }
            }
        </Formik>
    );
};

export default LoginPage;
