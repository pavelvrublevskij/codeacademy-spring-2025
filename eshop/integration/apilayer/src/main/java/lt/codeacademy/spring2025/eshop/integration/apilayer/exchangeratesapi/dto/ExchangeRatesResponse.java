package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto;

import java.util.Map;

/**
 * Example response from the API:
 * {
 *   "base": "EUR",
 *   "date": "2025-07-24",
 *   "rates": {
 *     "AED": 4.321333,
 *     "AFN": 81.767873,
 *     "ALL": 97.796364
 *   },
 *   "success": true,
 *   "timestamp": 1753382344
 * }
 */
public record ExchangeRatesResponse(
  String base,
  String date,
  Map<String, Double> rates,
  boolean success,
  long timestamp) {
}