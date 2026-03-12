package com.jay.apollo.core.port.outbound.http.client;

import java.util.List;

import com.jay.apollo.core.outbound.http.client.settings.HttpClientSettings;

public interface HttpClientSettingsProvider {

    List<HttpClientSettings> provide();
}
