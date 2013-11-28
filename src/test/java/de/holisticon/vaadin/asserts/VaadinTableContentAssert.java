package de.holisticon.vaadin.asserts;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import java.util.List;

public class VaadinTableContentAssert extends GenericAssert<VaadinTableContentAssert, List<List<String>>> {

    protected VaadinTableContentAssert(List<List<String>> actual) {
        super(VaadinTableContentAssert.class, actual);
    }

    public VaadinTableContentAssert containsRows(List<List<String>> expected) {
        Assertions.assertThat(actual.size()).overridingErrorMessage("wrong numbers of rows").isEqualTo(expected.size());
        for (int rowIdx = 0; rowIdx < expected.size(); rowIdx++) {
            for (int fieldIdx = 0; fieldIdx < expected.get(rowIdx).size(); fieldIdx++) {
                String actualValue = actual.get(rowIdx).get(fieldIdx);
                String expectedValue = expected.get(rowIdx).get(fieldIdx);
                Assertions.assertThat(actualValue).overridingErrorMessage("table contents are not as expected").isEqualTo(expectedValue);
            }
        }
        return this;
    }

    public static VaadinTableContentAssert assertThat(List<List<String>> table){
        return new VaadinTableContentAssert(table);
    }

}
