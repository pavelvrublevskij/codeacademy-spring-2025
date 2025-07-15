import HTTP from './axiosConfig';

const getProductsApi = () => HTTP.get('/products');

export { getProductsApi };
