#include <iostream>
#include <map>
#include <string>

int main() {
    int N;
    std::cin >> N;
    std::map<std::string, int> extensionCount;

    for (int i = 0; i < N; ++i) {
        std::string filename;
        std::cin >> filename;

        size_t pos = filename.rfind('.');
        if (pos != std::string::npos) {
            std::string extension = filename.substr(pos + 1);
            ++extensionCount[extension];
        }
    }

    for (const auto& pair : extensionCount) {
        std::cout << pair.first << " " << pair.second << "\n";
    }

    return 0;
}
