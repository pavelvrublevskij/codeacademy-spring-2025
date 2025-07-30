import HTTP from './axiosConfig';
import {ExchangeRatesResponse} from "./dto/ExchangeRatesResponse";
import {AxiosResponse} from "axios";

const getProductsApi = () => HTTP.get('/products');
const getExchangeRatesApi = (): Promise<AxiosResponse<ExchangeRatesResponse>> => HTTP.get('/integrations/exchange-rates');

export { getProductsApi, getExchangeRatesApi };
