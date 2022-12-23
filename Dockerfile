FROM ghcr.io/graalvm/graalvm-ce:ol7-java11-22.3.0

ADD . /build
WORKDIR /build

RUN yum install -y unzip zip

RUN \
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk install gradle; \
    gu install native-image;

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle -v

RUN native-image --version

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && gradle clean nativeCompile

RUN chmod +x bootstrap
RUN chmod +x ./build/native/nativeCompile/mn-gradle
RUN mv ./build/native/nativeCompile/mn-gradle ./app

RUN zip -j function.zip bootstrap app