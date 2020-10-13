[when]存在订单=$o:Order()
[when]存在优惠=$d:Discount()
[when]不满足优惠=$sum:Integer(doubleValue<$d.getMoney()) from accumulate(Item($money:money)from $o.getItems(),sum($money))
[when]满足优惠=$sum:Integer(doubleValue>=$d.getMoney()) from accumulate(Item($money:money)from $o.getItems(),sum($money))

[then]计算优惠=$o.setPreferentialMoney($d.getPreferentialMoney());
[then]结账=$o.setMoney($sum);
          $o.setActualMoney($sum-$o.getPreferentialMoney());
