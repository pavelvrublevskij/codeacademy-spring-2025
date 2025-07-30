import HTTP from './axiosConfig';

const getProductsApi = () => HTTP.get('/products');
const getExchangeRatesApi = () => HTTP.get('/integrations/exchange-rates');

export { getProductsApi, getExchangeRatesApi };
