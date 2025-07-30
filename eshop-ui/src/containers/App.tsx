import Header from './Header';
import Footer from './Footer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages/Page';
import {AuthUserContext, initialAuthUserState} from "../contexts/AuthUserContext";
import {useState} from "react";
import {LoginResponse} from "../config/api/dto/LoginRequest";

function App() {

    const [authUser, setAuthUser] = useState<LoginResponse>(initialAuthUserState);

    const authUserContextValue = {
        authUser,
        putAuthUser: (data: LoginResponse) => setAuthUser(data)
    };

    return (
        <BrowserRouter>
            <div className="mainApp">
                <AuthUserContext.Provider value={authUserContextValue}>
                    <Header />
                    <Pages />
                </AuthUserContext.Provider>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default App;
