package com.huobi.client.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeeRate {

  private String symbol;
  private BigDecimal makerFee;
  private BigDecimal takerFee;

}
