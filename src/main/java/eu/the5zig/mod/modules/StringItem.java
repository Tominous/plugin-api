/*
 * Copyright (c) 2019 5zig
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/MIT
 */

package eu.the5zig.mod.modules;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.render.RenderLocation;

/**
 * A module item that renders a simple text to the screen. Simply extend this class and
 * override {@link #getValue(boolean)}.
 */
public abstract class StringItem extends AbstractModuleItem {

	/**
	 * Renders a simple text as item onto the screen. The text needs to be returned from an extending class.
	 *
	 * @param x              the x-position of the item.
	 * @param y              the y-position of the item.
	 * @param renderLocation the {@link RenderLocation} of the item.
	 * @param dummy          true, if the item should render dummy values.
	 */
	@Override
	public void render(int x, int y, RenderLocation renderLocation, boolean dummy) {
		String text = getText(dummy);

		The5zigAPI.getAPI().getRenderHelper().drawString(text, x, y);
	}

	/**
	 * Only renders the item when {@link #getValue(boolean)} is not {@code null}.
	 *
	 * @param dummy true, if the item should render dummy values.
	 * @return true, if the item should be rendered.
	 */
	@Override
	public boolean shouldRender(boolean dummy) {
		return getValue(dummy) != null;
	}

	/**
	 * The actual text that will be rendered.
	 *
	 * @param dummy true, if the item should render dummy values.
	 * @return the actual text that will be rendered.
	 */
	private String getText(boolean dummy) {
		return getPrefix() + String.valueOf(getValue(dummy));
	}

	/**
	 * The width of the text.
	 *
	 * @param dummy true, if the item should render dummy values.
	 * @return the width of the module item.
	 */
	@Override
	public int getWidth(boolean dummy) {
		return The5zigAPI.getAPI().getRenderHelper().getStringWidth(getText(dummy));
	}

	/**
	 * The height of the text.
	 *
	 * @param dummy true, if the item should render dummy values.
	 * @return the height of the module item.
	 */
	@Override
	public int getHeight(boolean dummy) {
		return 10;
	}

	/**
	 * Needs to be implemented to return a custom value.
	 *
	 * @param dummy true, if the method should return dummy values.
	 * @return a value that should be rendered or {@code null} if the item should not be rendered to the screen.
	 */
	protected abstract Object getValue(boolean dummy);
}
