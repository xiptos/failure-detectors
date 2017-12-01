package message.internal;

/**
 * A control message used to tell a broker that it should simulate a process recovery.
 */
public class ResurrectMessage implements BrokeredMessage {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4682104469409437061L;
	private final int processId;

    /**
     * Construct a new message.
     *
     * @param processId ID of the recovered process.
     */
    public ResurrectMessage(int processId) {
        this.processId = processId;
    }

    /**
     * Get ID of the recovered process.
     *
     * @return process ID.
     */
    public int getProcessId() {
        return processId;
    }
}
