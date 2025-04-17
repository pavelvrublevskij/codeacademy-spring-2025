package lt.codeacademy.spring2025.eshop.core.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EshopFormatConstant {

  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String TIME_FORMAT = "HH:mm:ss";
  public static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;
}
