import HTTP from './axiosConfig';
import {ExchangeRatesResponse} from "./dto/ExchangeRatesResponse";
import {LoginRequest, LoginResponse} from "./dto/LoginRequest";
import {AxiosResponse} from "axios";

const getProductsApi = (): Promise<AxiosResponse<any>> => HTTP.get('/products');
const getExchangeRatesApi = (): Promise<AxiosResponse<ExchangeRatesResponse>> => HTTP.get('/integrations/exchange-rates');
const loginApi = (loginData: LoginRequest): Promise<AxiosResponse<LoginResponse>> => HTTP.post("/login", loginData)

export { getProductsApi, getExchangeRatesApi, loginApi };
