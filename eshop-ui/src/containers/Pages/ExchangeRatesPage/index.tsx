import { useEffect, useState } from 'react';
import { getExchangeRatesApi } from '../../../config/api/eshopApiEndpoints';

interface ExchangeRatesProps {
    rates: {
        currency: string,
        rate: number,
    },
    base: string,
    date: string
}

const initialRatesState: ExchangeRatesProps = {
    rates: {
        currency: '',
        rate: 0,
    },
    base: '',
    date: '',
};

const ExchangeRatesPage = () => {
    const [ratesData, setRatesData] = useState<ExchangeRatesProps>(initialRatesState);

    useEffect(() => {
        getExchangeRatesApi()
            .then((response) => {
                console.log(response);
                setRatesData(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    return (
        <div>
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
    );
};

export default ExchangeRatesPage;
