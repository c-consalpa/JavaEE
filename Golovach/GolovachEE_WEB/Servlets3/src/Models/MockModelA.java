package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockModelA {
    private Map<String, String> map;
    private List<String> list;
    private int[] array_int;
    private String string;
    private MockModelB mockModelB;

    public MockModelA() {
        map = new HashMap<>();
        map.put("key-0","one");
        list = new ArrayList<>();
        list.add("first");
        array_int = new int[5];
        array_int[0] = 1;
        string = "initString";
        mockModelB = new MockModelB();
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int[] getArray_int() {
        return array_int;
    }

    public void setArray_int(int[] array_int) {
        this.array_int = array_int;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public MockModelB getMockModelB() {
        return mockModelB;
    }

    public void setMockModelB(MockModelB mockModelB) {
        this.mockModelB = mockModelB;
    }
}
