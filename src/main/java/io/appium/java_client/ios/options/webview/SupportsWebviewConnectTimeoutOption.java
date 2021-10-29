/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.ios.options.webview;

import io.appium.java_client.internal.CapabilityHelpers;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.remote.options.CanSetCapability;
import org.openqa.selenium.Capabilities;

import java.time.Duration;
import java.util.Optional;

public interface SupportsWebviewConnectTimeoutOption<T extends BaseOptions<T>> extends
        Capabilities, CanSetCapability<T> {
    String WEBVIEW_CONNECT_TIMEOUT_OPTION = "webviewConnectTimeout";

    /**
     * The time to wait for the initial presence of webviews in
     * MobileSafari or hybrid apps. Defaults to 0ms.
     *
     * @param timeout Timeout to wait for the initial presence of webviews.
     * @return self instance for chaining.
     */
    default T setWebviewConnectTimeout(Duration timeout) {
        return amend(WEBVIEW_CONNECT_TIMEOUT_OPTION, timeout.toMillis());
    }

    /**
     * Get the timeout to wait for the initial presence of webviews.
     *
     * @return Timeout value.
     */
    default Optional<Duration> getWebviewConnectTimeout() {
        return Optional.ofNullable(
                CapabilityHelpers.toDuration(getCapability(WEBVIEW_CONNECT_TIMEOUT_OPTION))
        );
    }
}
