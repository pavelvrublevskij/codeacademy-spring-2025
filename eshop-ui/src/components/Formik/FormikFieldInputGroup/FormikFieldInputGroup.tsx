import { Form, InputGroup } from 'react-bootstrap';
import { FieldProps } from 'formik';

interface FormikFieldInputGroupProps<T = any> {
    labelText: string;
    type?: string;
    field: FieldProps<string, T>['field'];
    form: any;
}

const FormikFieldInputGroup = ({
    field,
    form,
    labelText,
    type = 'text'
}: FormikFieldInputGroupProps) => {
    const isValid = !form.errors[field.name];
    const isInvalid = form.touched[field.name] && !isValid;
    return (
        <Form.Group controlId={field.name}>
            <Form.Label>{labelText}</Form.Label>
            <InputGroup>
                <Form.Control
                    type={type}
                    name={field.name}
                    isValid={form.touched[field.name] && isValid}
                    isInvalid={isInvalid}
                    onChange={field.onChange}
                />
                <Form.Control.Feedback type="invalid">
                    {form.errors[field.name]}
                </Form.Control.Feedback>
            </InputGroup>
        </Form.Group>
    );
}

export default FormikFieldInputGroup;
