import HTTP from './axiosConfig';

const getProducts = () => HTTP.get('/products');

export { getProducts };
