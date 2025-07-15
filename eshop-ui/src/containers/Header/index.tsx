import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

const HeaderContainer = () =>
    <Navbar expand="lg" className="bg-body-tertiary" bg="dark" data-bs-theme="dark">
        <Container fluid>
            <Navbar.Brand href="/">E-Shop</Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{ maxHeight: '100px' }}
                    navbarScroll
                >
                    <Nav.Link href="/">Home</Nav.Link>
                    <Nav.Link href="/products">Products</Nav.Link>
                    <NavDropdown title="Languages" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="#action3">LT</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">EN</NavDropdown.Item>
                        <NavDropdown.Item href="#action4">DE</NavDropdown.Item>
                    </NavDropdown>
                </Nav>
                <Form className="d-flex">
                    <Form.Control
                        type="search"
                        placeholder="Search"
                        className="me-2"
                        aria-label="Search"
                    />
                    <Button variant="outline-success">Search</Button>
                </Form>
                <Nav.Link href="#" disabled>
                    Login
                </Nav.Link>
            </Navbar.Collapse>
        </Container>
    </Navbar>;

export default HeaderContainer;
