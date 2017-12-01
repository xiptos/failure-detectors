package process.demo;

import static java.lang.Thread.sleep;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Ignore;
import org.junit.Test;

import broker.Broker;
import broker.GaussianDelayBroker;
import process.LeaderElectingEventuallyPerfectFailureDetectorProcess;
import process.ProcessSmokeTest;

/**
 * Demo of {@link process.LeaderElectingEventuallyPerfectFailureDetectorProcess}. Gaussian delay is used.
 */
@Ignore("only for demo purposes")
public class LeaderElectionDemo extends ProcessSmokeTest<LeaderElectingEventuallyPerfectFailureDetectorProcess> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Broker createBroker() {
        return new GaussianDelayBroker(3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LeaderElectingEventuallyPerfectFailureDetectorProcess createProcess(String processName, int processId, int numberOfProcesses) {
        return new LeaderElectingEventuallyPerfectFailureDetectorProcess(processName, processId, numberOfProcesses);
    }

    @Test
    public void justWatchWithNoFailures() throws InterruptedException, ExecutionException, IOException {
        launchProcesses(3);
        sleep(100000);
    }

    @Test
    public void justWatchWithAFailure() throws InterruptedException, ExecutionException, IOException {
        launchProcesses(3);

        sleep(1000);

        killProcesses(3);

        sleep(2000);

        resurrectProcesses(3);

        sleep(100000);
    }
}
