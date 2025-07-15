import Container from 'react-bootstrap/Container';

const FooterContainer = () => (
    <footer className="fixed-bottom">
        <Container className={'text-center'}>
            <span className="text-muted">
                CodeAcademy. React Bootstrap. All Rights reserved{' '}
            </span>
        </Container>
    </footer>
);

export default FooterContainer;
