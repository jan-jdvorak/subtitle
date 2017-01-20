package fr.noop.subtitle.base;

import fr.noop.subtitle.model.SubtitleObject;
import fr.noop.subtitle.model.SubtitleParser;
import fr.noop.subtitle.model.SubtitleParsingException;
import fr.noop.subtitle.model.ValidationIssue;
import fr.noop.subtitle.model.ValidationListener;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jdvorak on 20.1.2017.
 */
//@Slf4j
public abstract class BaseSubtitleParser implements SubtitleParser {
    private ValidationListener[] listeners;

    public BaseSubtitleParser() {

    }

    @Override
    public SubtitleObject parse(InputStream is) throws IOException, SubtitleParsingException {
        return parse(is, 0,-1, true);
    }

    @Override
    public SubtitleObject parse(InputStream is, boolean strict) throws IOException, SubtitleParsingException {
        return parse(is, 0,-1, strict);
    }

    @Override
    public SubtitleObject parse(InputStream is, int subtitleOffset, boolean strict) throws IOException, SubtitleParsingException {
        return parse(is, subtitleOffset,-1, strict);
    }

    public void addValidationListener(ValidationListener listener) {
        int len = 0;
        if (listeners != null) {
            len = listeners.length;
        }
        ValidationListener[] newListeners = new ValidationListener[len + 1];
        if (listeners != null) {
            System.arraycopy(listeners, 0, newListeners, 0, len);
        }
        newListeners[len] = listener;
        listeners = newListeners;
    }

    protected void notifyWarning(String msg, int lineNr) {
        if (listeners != null) {
            ValidationIssue issue = new ValidationIssue(ValidationIssue.Severity.WARNING, msg, lineNr, 0);
            for (ValidationListener listener : listeners) {
                listener.onValidation(issue);
            }
        }
    }

    protected void notifyError(String msg, int lineNr) throws SubtitleParsingException {
        ValidationIssue issue = new ValidationIssue(ValidationIssue.Severity.WARNING, msg, lineNr, 0);
        if (listeners != null) {
            for (ValidationListener listener : listeners) {
                listener.onValidation(issue);
            }
        }
        throw new SubtitleParsingException(issue);
    }
}