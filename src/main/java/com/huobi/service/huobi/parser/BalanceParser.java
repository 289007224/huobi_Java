package com.huobi.service.huobi.parser;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.huobi.constant.enums.BalanceTypeEnum;
import com.huobi.model.account.Balance;

public class BalanceParser implements HuobiModelParser<Balance> {

  @Override
  public Balance parse(JSONObject json) {
    Balance balance = json.toJavaObject(Balance.class);
    balance.setType(BalanceTypeEnum.find(json.getString("type")));
    return balance;
  }

  @Override
  public List<Balance> parseArray(JSONArray jsonArray) {
    List<Balance> balanceList = new ArrayList<>(jsonArray.size());
    for (int i = 0; i < jsonArray.size(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      balanceList.add(parse(jsonObject));
    }
    return balanceList;
  }
}
