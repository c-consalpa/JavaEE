/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa.business;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {
    public static Map<Integer, String> mockStorage = new HashMap<>();

    public MockStorage() {
        mockStorage.put(1, "sugar");
        mockStorage.put(2, "bread");
        mockStorage.put(3, "oil");
    }
}