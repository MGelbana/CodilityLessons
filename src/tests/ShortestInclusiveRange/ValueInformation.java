package tests.ShortestInclusiveRange;

public class ValueInformation {
    private int value;
    private int firstOccurrence;
    private int lastOccurrence;
    private int singleOccurrenceIndex;

    public ValueInformation(int value, int firstOccurrence) {
        super();
        this.value = value;
        this.firstOccurrence = firstOccurrence;
    }

    public int getFirstOccurrence() {
        return firstOccurrence;
    }

    public void setFirstOccurrence(int firstOccurrence) {
        this.firstOccurrence = firstOccurrence;
    }

    public int getLastOccurrence() {
        return lastOccurrence;
    }

    public void setLastOccurrence(int lastOccurrence) {
        this.lastOccurrence = lastOccurrence;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ValueInformation other = (ValueInformation) obj;
        if (value != other.value)
            return false;
        return true;
    }

    public int getSingleOccurrenceIndex() {
        return singleOccurrenceIndex;
    }

    public void setSingleOccurrenceIndex(int singleOccurrenceIndex) {
        this.singleOccurrenceIndex = singleOccurrenceIndex;
    }
}