package pl.ozdoba.datajoiner.domain;

public class AddIntegersOperator implements DataOperator<Integer> {

    @Override
    public Integer join(Integer firstData, Integer secondData) {
        return firstData + secondData;
    }
}
