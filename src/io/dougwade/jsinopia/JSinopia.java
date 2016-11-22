package io.dougwade.jsinopia;

import com.eclipsesource.v8.NodeJS;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.Releasable;

import java.io.File;

public class JSinopia {
	public static void main(String [] args) {
		final String BUNDLE_FILE_PATH = "bundle.js";

		final NodeJS nodeJS = NodeJS.createNodeJS();
	  	final V8Object sinopia = nodeJS.require(new File(BUNDLE_FILE_PATH));

		V8Function callback = new V8Function(nodeJS.getRuntime(), new JavaCallback() {
			public Object invoke(V8Object receiver, V8Array parameters) {
				final V8Object image = parameters.getObject(1);
				executeJSFunction(image, "posterize", 7);
				executeJSFunction(image, "greyscale");
				executeJSFunction(image, "write",  "path_to_output");
				image.release();
				return null;
			}
		});
		executeJSFunction(sinopia, "read", "path_to_image", callback);

		while(nodeJS.isRunning()) {
		nodeJS.handleMessage();
		}
		callback.release();
		sinopia.release();
		nodeJS.release();
	}

	public static void executeJSFunction(V8Object object, String name) {
		Object result = object.executeFunction(name, null);
		if (result instanceof Releasable) {
			((Releasable) result).release();
		}
	}

	public static void executeJSFunction(V8Object object, String name, Object... params) {
		Object result = object.executeJSFunction(name, params);
		if (result instanceof Releasable) {
			((Releasable) result).release();
		}
	}

}
