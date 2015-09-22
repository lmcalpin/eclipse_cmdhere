package org.metatrope.cmdhere.popup.actions;

public class OpenShellAction extends CommandExecutingAction {

	/**
	 * Constructor for OpenShellAction.
	 */
	public OpenShellAction() {
		super();
	}

	@Override
    public String[] getCommand(String fullPath) {
		if (isWindows()) {
			return new String[]{"cmd.exe", "/c", "start", "cmd.exe"};
		} else if (isMacOSX()) {
			return new String[] {"/usr/bin/open", "-a", "Terminal.app", fullPath};
		} else {
			throw new UnsupportedOSException();
		}
	}
}
