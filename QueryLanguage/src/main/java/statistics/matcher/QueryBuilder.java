/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author mevid
 */
public class QueryBuilder {

    Matcher m;

    public QueryBuilder() {
        this.m = new All();
    }

    public Matcher build() {
        return m;
    }

    public QueryBuilder playsIn(String team) {
        this.m = new And(m, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(m, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(m, new HasFewerThan(value, category));
        return this;
    }

}
