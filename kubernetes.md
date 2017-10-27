# Kubernetes - wie verwendet man es?

## minikube

Diese Demo wurde mit Hilfe einer minikube Installation erstellt und getestet. Die Installation von minikube ist auf der [minikube-Webseite](https://github.com/kubernetes/minikube) ausführlich dokumentiert. 

### Starten

Damit die Tests im Kubernetes Cluster nicht eine evtl schon vorhandene minikube Umgebung beeinträchtigen und auch 
problemlos wieder gelöscht werden können, empfiehlt es sich, ein minikube Profil (hier mit der Bezeichnung _infakt_ 
für _informatik-aktuell_) zu verwenden.

    export MINIKUBE_PROFILE=infakt

Dies führt dazu, dass eine virtuelle Maschine (Knoten) mit dem Hostnamen _infakt_ erstellt wird, die dann einen 
frischen 
Kubernetes Cluster enthält und die z.B. mit `minikube delete` auch wieder komplett gelöscht werden kann.

Beim Start ist der passende VM-Treiber anzugeben und der Hauptspeicher für den Knoten, z.B. für OSX und 4GB RAM:

    minikube start --vm-driver xhyve --memory 4096
    
minikube kann jederzeit gestoppt und wieder gestartet werden:

    minikube stop
    minikube start
    
### Kubernetes Dashboard

in minikube wird durch den Befehl 

    minikube dashboard
    
das Kubernetes dashboard im Browser angezeigt. Alternativ kann auch der konventionelle Aufruf mit ` 

    kubectl proxy &
     
gemacht werden, so dass dan über http://localhost:8001/ui das Dashboard zur Verfügung steht.   

## notwendige Anpassungen

damit Elasticsearch im Cluster läuft ist eine wichtige Anpassung der Systemeinstellung `vm.max_map_count` notwendig, siehe auch die [Elasticsearch Dokumentation](https://www.elastic.co/guide/en/elasticsearch/reference/5.6/docker.html).

Für minikube geht das, indem man sich in die virtuelle Maschine einloggt und die Systemkonfiguration anpasst:

    minikube ssh
    sudo sysctl -w vm.max_map_count=262144
    exit

Nach `minikube stop` and `minikube start` muss der Wert erneut eingetragen werden. 
