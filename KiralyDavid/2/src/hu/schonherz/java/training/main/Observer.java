package hu.schonherz.java.training.main;

import java.io.File;
import java.util.TimerTask;

public abstract class Observer extends TimerTask {

    private long modDate;
    private File file;

    public Observer(File file) {
        this.file = file;
        this.modDate = file.lastModified();
    }

    public final void run() {
        long modDate = file.lastModified();

        if (this.modDate != modDate) {
            this.modDate = modDate;
            onChange(file);
        }

    }

    protected abstract void onChange(File file);
}
