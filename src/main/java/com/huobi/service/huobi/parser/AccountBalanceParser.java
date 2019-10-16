package com.huobi.service.huobi.parser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.huobi.constant.enums.AccountStateEnum;
import com.huobi.constant.enums.AccountTypeEnum;
import com.huobi.model.account.AccountBalance;

public class AccountBalanceParser implements HuobiModelParser<AccountBalance> {

  @Override
  public AccountBalance parse(JSONObject json) {

    AccountBalance accountBalance = json.toJavaObject(AccountBalance.class);
    accountBalance.setType(AccountTypeEnum.find(json.getString("type")));
    accountBalance.setState(AccountStateEnum.find(json.getString("state")));
    accountBalance.setUserId(json.getLong("user-id"));
    accountBalance.setList(new BalanceParser().parseArray(json.getJSONArray("list")));

    return accountBalance;
  }

  @Override
  public List<AccountBalance> parseArray(JSONArray jsonArray) {
    return null;
  }
}
