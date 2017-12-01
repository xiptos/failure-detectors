package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import broker.Broker;
import broker.FailureInjector;
import process.base.Process;

/**
 * Util class with convenience methods for process smoke tests.
 */
public abstract class ProcessSmokeTest<T extends process.base.Process> {

    private Broker broker;
    private FailureInjector failureInjector;
    protected final List<T> processes = new ArrayList<T>();

    @Before
    public void setUp() {
        broker = createBroker();
        failureInjector = new FailureInjector();
    }

    protected abstract Broker createBroker();

    @After
    public void tearDown() {
        for (Process process : processes) {
            process.stop();
        }
        broker.shutdown();
    }

    protected void launchProcess(int processId, int numberOfProcesses) {
        T process = createProcess("Process" + processId, processId, numberOfProcesses);
        processes.add(process);
        process.start();
    }

    protected void launchProcesses(int number) {
        for (int i = 1; i <= number; i++) {
            launchProcess(i, number);
        }
    }

    protected abstract T createProcess(String processName, int processId, int numberOfProcesses);

    public void killProcesses(int... processIds) throws IOException {
        for (int pid : processIds) {
            failureInjector.killProcess(pid);
        }
    }

    public void resurrectProcesses(int... processIds) throws IOException {
        for (int pid : processIds) {
            failureInjector.restoreProcess(pid);
        }
    }
}
