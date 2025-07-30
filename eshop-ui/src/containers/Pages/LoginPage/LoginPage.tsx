import {Field, Form, Formik, FormikProps} from 'formik';
import {
    Button,
    Container, Spinner,
} from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/Formik/FormikFieldInputGroup/FormikFieldInputGroup';
import * as Yup from 'yup';
import {ObjectSchema} from "yup";
import {loginApi} from "../../../config/api/eshopApiEndpoints";
import {useContext} from "react";
import {AuthUserContext} from "../../../contexts/AuthUserContext";

interface LoginValues {
    email: string;
    password: string;
}

const validationSchema: ObjectSchema<{ email: string, password: string }> = Yup.object().shape({
    email: Yup.string()
        .min(5, 'Ilgis turi buti ne mazesnis nei 5')
        .required()
        //.email()
        .matches(/^(.+)@(.+)$/, 'email neatitinka standarto'),
    password: Yup.string()
        .min(3, 'Slaptazodzio ilgis turi buti >= 3')
        .required(),
});

const LoginPage = () => {

    const authUserContextValue = useContext(AuthUserContext);

    const postLogin = (login: any, helper: any) => {
        loginApi({
            username: login.email,
            password: login.password
        }).then((response) =>
            // console.log('login response', response.data)
            authUserContextValue.putAuthUser(response.data)
        ).catch((error) =>
            console.log(error)
        ).finally(() =>
            helper.setSubmitting(false)
        );
    }

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={postLogin}
            validationSchema={validationSchema}
        >
            {
                (props: FormikProps<LoginValues>) => {
                    console.log('React formik props', props)

                    return (
                        <Container>
                            <Form>
                                <Field name="email" component={FormikFieldInputGroup} labelText="Email:" type="text"/>
                                <Field name="password" component={FormikFieldInputGroup} labelText="Password:" type="password"/>
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
                                        : <Button type='submit'
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
