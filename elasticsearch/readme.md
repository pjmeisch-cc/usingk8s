# Elasticsearch

Durch die Konfigurationsdatei [elasticsearch.yaml](elasticsearch.yaml) werden ein Deployment und ein Service für Elasticsearch im Kubernetes Cluster definiert.

## das Deployment

Das Deployment verwendet das offizielle ElasticSearch Image in Version 5.6.3 in zwei Replicas.
 
## der Service

Der Service mit Namen _elasticsearch_ fasst die Pods aus dem Deployment als _Headless Service_ zusammen; das bedeutet, dass innerhalb des Clusters der DNS Name _elasticsearch_ zu zu einer Service IP aufgelöst wird, welche dann als Loadbalancer-Adresse dient, sondern der DNS Server liefert für diesen Service eine Array von IP Adressen als  DNS A-Records.

Elasticsearch benötigt diese Einstellung, um die Elasticsearch Instanzen zu finden.
