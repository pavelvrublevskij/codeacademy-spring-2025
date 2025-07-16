import Form from 'react-bootstrap/Form';
import * as React from 'react';

interface FormLabelControlProps {
    className: string;
    labelText: string;
    placeholderText: string;
    name: string;
    isTextArea?: boolean;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const FormLabelControl = ({
    className,
    labelText,
    placeholderText,
    name,
    isTextArea = false,
    onChange,
}: FormLabelControlProps) => {
    return (
        <Form.Group className={className} controlId={name}>
            <Form.Label>{labelText}</Form.Label>
            {isTextArea ? (
                <Form.Control
                    as="textarea"
                    rows={3}
                    placeholder={placeholderText}
                    name={name}
                    onChange={onChange}
                />
            ) : (
                <Form.Control
                    placeholder={placeholderText}
                    name={name}
                    onChange={onChange}
                />
            )}
        </Form.Group>
    );
};

export default FormLabelControl;
