let intervalId;
document.addEventListener("DOMContentLoaded", function () {
    // 初回データ取得
    fetchChatData();

    intervalId = setInterval(() => {
        fetchChatData().then((data) => displayChatMessages(data));
    }, 5000);

    // チャットデータを取得する関数
    function fetchChatData() {
        return fetch("/api/getChat")
            .then((response) => {
                // if (!response.ok) {
                //   throw new Error(`HTTP error! Status: ${response.status}`);
                // }
                return response.json();
            })
            .catch(e => {
                console.error(e);
            });
    }

    // エラーハンドリング
    function handleFetchError(error) {
        console.error("Error fetching chat data:", error);
    }

    // メッセージを表示する関数
    function displayChatMessages(messages) {
        const chatContainer = document.getElementById("chat-container");

        // チャットコンテナをクリア
        chatContainer.innerHTML = "";

        messages.reverse();

        // メッセージを順番に追加
        messages.forEach((message, index) => {
            const messageElement = document.createElement("div");
            messageElement.className = "chat-message";

            // メッセージの内容を設定
            messageElement.textContent = `${message.name}: ${message.message}: ${message.sendTime}`;

            // 偶数番目のメッセージには異なるスタイルを適用
            if (index % 2 === 0) {
                messageElement.classList.add("user-message");
            }

            // メッセージをチャットコンテナに追加
            chatContainer.appendChild(messageElement);
        });

        // 最新のメッセージにスクロール
        chatContainer.scrollTop = chatContainer.scrollHeight;
    }
});

// ページが閉じられる前にタイマー解除とデータ削除
window.addEventListener("beforeunload", function () {
    if (intervalId) {
        clearInterval(intervalId); // タイマーを解除

        let matchingId = document.getElementById('matching-data').getAttribute('data-matching-id');
        let url = '/api/deleteMatch?matchingId=' + matchingId;
        navigator.sendBeacon(url);
    }
});
