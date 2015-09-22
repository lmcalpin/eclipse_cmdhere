package org.metatrope.cmdhere.popup.actions;


public class OpenExplorerAction extends CommandExecutingAction {

    /**
     * Constructor for OpenExplorerAction.
     */
    public OpenExplorerAction() {
        super();
    }

    @Override
    public String[] getCommand(String fullPath) {
        if (isWindows()) {
            return new String[] { "explorer.exe", fullPath};
        } else if (isMacOSX()) {
            return new String[] { "/usr/bin/open", fullPath};
        } else if (isLinux()) {
            return new String[] { "nautilus", fullPath};
        } else {
        	throw new UnsupportedOSException();
        }
    }
}
