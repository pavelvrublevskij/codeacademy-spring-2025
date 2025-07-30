import {Context, createContext} from "react";
import {LoginResponse} from "../config/api/dto/LoginRequest";

const AuthUserContext: Context<any> = createContext(null);

const initialAuthUserState: LoginResponse = {
    username: '',
    token: '',
    tokenExpiresAt: 0
};

export {
    AuthUserContext,
    initialAuthUserState
}
