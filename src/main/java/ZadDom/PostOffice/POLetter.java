package ZadDom.PostOffice;

public class POLetter {
    private Address senderAddress;
    private Address recipientAddress;
    private boolean priority;
    private DeliveryStatus letterStatus = DeliveryStatus.SUBMITTED;

    public POLetter(Address senderAddress, Address recipientAddress) {
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;

    }

    public POLetter(Address senderAddress, Address recipientAddress, boolean priority) {
        this(senderAddress, recipientAddress);
        this.priority = priority;
    }

    public double calculateLetterCost() {
        return priority ? 8.50 : 6.0;
    }


    public DeliveryStatus getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(DeliveryStatus letterStatus) {
        this.letterStatus = letterStatus;
    }

    @Override
    public String toString() {
        String letterOutput = "From: " + senderAddress.toString() + " To: " + recipientAddress.toString() + " Status: " + letterStatus;

        return priority ? "Priority letter " + letterOutput : "Letter " + letterOutput;
    }
}
