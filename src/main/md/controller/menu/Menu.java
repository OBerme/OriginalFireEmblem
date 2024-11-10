package main.md.controller.menu;

import main.ln.controller.menu.IMenuShowable;

public abstract class Menu implements IMenuShowable{
	public abstract Integer[] getOptions();
}
