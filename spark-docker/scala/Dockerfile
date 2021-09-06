FROM openjdk:8-alpine AS builder
WORKDIR /root
ADD https://archive.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz /root/spark-2.4.4-bin-hadoop2.7.tgz
RUN tar -xvf /root/spark-2.4.4-bin-hadoop2.7.tgz

FROM openjdk:8-alpine

ARG spark_jars=jars
ARG img_path=kubernetes/dockerfiles
ARG k8s_tests=kubernetes/tests

RUN set -ex && \
    apk upgrade --no-cache && \
    ln -s /lib /lib64 && \
    apk add --no-cache bash tini libc6-compat linux-pam nss && \
    mkdir -p /opt/spark && \
    mkdir -p /opt/spark/work-dir && \
    touch /opt/spark/RELEASE && \
    rm /bin/sh && \
    ln -sv /bin/bash /bin/sh && \
    echo "auth required pam_wheel.so use_uid" >> /etc/pam.d/su && \
    chgrp root /etc/passwd && chmod ug+rw /etc/passwd

COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/${spark_jars} /opt/spark/jars
COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/bin /opt/spark/bin
COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/sbin /opt/spark/sbin
COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/examples /opt/spark/examples
COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/${k8s_tests} /opt/spark/tests
COPY --from=builder /root/spark-2.4.4-bin-hadoop2.7/data /opt/spark/data
COPY entrypoint.sh /opt/



ENV SPARK_HOME /opt/spark

# Updating the kubernetes client to fix pod with null name bug
RUN rm $SPARK_HOME/jars/kubernetes-client-4.1.2.jar
ADD https://repo1.maven.org/maven2/io/fabric8/kubernetes-client/4.4.2/kubernetes-client-4.4.2.jar $SPARK_HOME/jars
RUN chmod 644 $SPARK_HOME/jars/kubernetes-client-4.4.2.jar

WORKDIR /opt/spark/work-dir

ENTRYPOINT [ "/opt/entrypoint.sh" ]
