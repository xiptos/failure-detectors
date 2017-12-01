package message;

import static broker.ActiveMqBroker.BROADCAST_DESTINATION;

/**
 * A heartbeat message that is broadcast.
 */
public class HeartbeatMessage extends TimestampedProcessToProcessMessage {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8703775455343817231L;

	/**
     * Construct a new heartbeat to be broadcast.
     *
     * @param source ID of the source process.
     */
    public HeartbeatMessage(int source) {
        super(source, BROADCAST_DESTINATION);
    }

    @Override
    public String toString() {
        return "HB:" + getSource();
    }
}
