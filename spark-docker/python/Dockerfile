ARG base_img

FROM $base_img

WORKDIR /

RUN mkdir ${SPARK_HOME}/python

RUN apk add --no-cache python && \
    apk add --no-cache python3 && \
    python -m ensurepip && \
    python3 -m ensurepip && \
    rm -r /usr/lib/python*/ensurepip && \
    pip install --upgrade pip setuptools

COPY python/lib ${SPARK_HOME}/python/lib
ENV PYTHONPATH ${SPARK_HOME}/python/lib/pyspark.zip:${SPARK_HOME}/python/lib/py4j-*.zip

WORKDIR /opt/spark/work-dir
ENTRYPOINT ["/opt/entrypoint.sh"]