export interface ExchangeRatesResponse {
    rates: {
        currency: string,
        rate: number,
    },
    base: string,
    date: string
}
