package io.javaoperatorsdk.operator.processing;

import io.fabric8.kubernetes.client.CustomResource;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceCache {

    private final Map<String, CustomResource> resources = new ConcurrentHashMap<>();

    public void cacheResource(CustomResource resource) {
        resources.put(resource.getMetadata().getUid(), resource);
    }

    public Optional<CustomResource> getLatestResource(String uuid) {
        return Optional.ofNullable(resources.get(uuid));
    }

    public CustomResource cleanup(String customResourceUid) {
        return resources.remove(customResourceUid);
    }
}
