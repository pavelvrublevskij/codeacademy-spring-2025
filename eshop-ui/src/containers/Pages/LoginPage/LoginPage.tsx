import { Field, Form, Formik, FieldProps, FormikProps } from 'formik';
import {
    Button,
    Container,
    Form as BootstrapForm,
    InputGroup,
} from 'react-bootstrap';

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
                                <Field name="email">
                                    {({ field, form }: FieldProps<string, LoginValues>) => {  // form -> Field form props
                                        const fieldName = field.name as keyof LoginValues;
                                        const isValid = !form.errors[fieldName];
                                        const isInvalid = form.touched[fieldName] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId={field.name}>
                                                <BootstrapForm.Label>Email:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[fieldName] && isValid}
                                                        isInvalid={isInvalid}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[fieldName]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                                <Field name="password">
                                    {({ field, form }: FieldProps<string, LoginValues>) => {  // form -> Field form props
                                        const fieldName = field.name as keyof LoginValues;
                                        const isValid = !form.errors[fieldName];
                                        const isInvalid = form.touched[fieldName] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId={field.name}>
                                                <BootstrapForm.Label>Password:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='password'
                                                        name={field.name}
                                                        isValid={form.touched[fieldName] && isValid}
                                                        isInvalid={isInvalid}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[fieldName]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                                <div>
                                    <Button type='submit'>Submit</Button>
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
