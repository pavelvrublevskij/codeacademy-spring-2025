import {useEffect, useState} from 'react';
import {getExchangeRatesApi} from '../../../config/api/eshopApiEndpoints';
import {ExchangeRatesResponse} from "../../../config/api/dto/ExchangeRatesResponse";

const initialRatesState: ExchangeRatesResponse = {
    rates: {
        currency: '',
        rate: 0,
    },
    base: '',
    date: '',
};

const ExchangeRatesPage = () => {
    const [ratesData, setRatesData] = useState<ExchangeRatesResponse>(initialRatesState);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        console.log(1);
        getExchangeRatesApi()
            .then((response) => {
                console.log(2);
                // console.log(response);
                setRatesData(response.data);
            })
            .catch((error) => {
                console.log(error);
            })
            .finally(() => setLoading(false));
    }, []);

    return (
        <>
            {loading
                ? <span>Loading...</span>
                : <div>
                    <h2>Exchange Rates for {ratesData.date}</h2>
                    <p>Base Currency: {ratesData.base}</p>
                    <table>
                        <thead>
                        <tr>
                            <th>Currency</th>
                            <th>Exchange Rate</th>
                        </tr>
                        </thead>
                        <tbody>
                        {Object.entries(ratesData.rates).map(([currency, rate]) => (
                            <tr key={currency}>
                                <td>{currency}</td>
                                <td>{rate}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            }
        </>
    );
};

export default ExchangeRatesPage;
