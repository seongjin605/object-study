package com.obj.study._02;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    /**
     * 파라미터로 전달된 screening의 사영 순번과 일치할 경우 할인 가능한지 판단
     * @param screening
     * @return
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
