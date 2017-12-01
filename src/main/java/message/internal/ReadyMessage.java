package message.internal;

/**
 * A control message indicating to the broker that a process is ready, or the broker indicating to all processes
 * that everyone is ready (source = 0).
 */
public class ReadyMessage implements ProcessMessage {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6956867065175552813L;
	private final int source;

    /**
     * Construct a new message.
     *
     * @param source ID of the originating process, 0 for broker.
     */
    public ReadyMessage(int source) {
        this.source = source;
    }

    /**
     * Get the source of the message.
     *
     * @return ID of the originating process, 0 for broker.
     */
    public int getSource() {
        return source;
    }
}
