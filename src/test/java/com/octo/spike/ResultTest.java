package com.octomga.foobarqix;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ResultTest {

    @Test public void should_compute_result() {
        Result resultFail = new Result();
        Map<String,Object> valuesFail = Maps.newHashMap();
        valuesFail.put("FAIL",3);
        resultFail.setValues(valuesFail);

        Result resultOk = new Result();
        Map<String,Object> valuesOk = Maps.newHashMap();
        valuesOk.put("OK",100);
        resultOk.setValues(valuesOk);

        List<Result> results = Lists.newArrayList(resultFail,resultOk);

        Result result1 = FluentIterable.from(results).first().get();
        Assert.assertEquals(resultFail.getValues(),result1.getValues());
        Assert.assertEquals(3,result1.getValues().get("FAIL"));

        Result result2 = FluentIterable.from(results).last().get();
        Assert.assertEquals(resultOk.getValues(),result2.getValues());
        Assert.assertEquals(100,result2.getValues().get("OK"));
        Double fail = new Double((Integer)result1.getValues().get("FAIL"));
        Double ok = new Double((Integer)result2.getValues().get("OK"));
        Assert.assertEquals(0.03,fail/ok);
    }
}
